import request from '@/utils/request'

// 查询关键技术列表
export function listProjec(query) {
  return request({
    url: '/projec/projec/list',
    method: 'get',
    params: query
  })
}

// 查询关键技术详细
export function getProjec(id) {
  return request({
    url: '/projec/projec/' + id,
    method: 'get'
  })
}

// 新增关键技术
export function addProjec(data) {
  return request({
    url: '/projec/projec',
    method: 'post',
    data: data
  })
}

// 修改关键技术
export function updateProjec(data) {
  return request({
    url: '/projec/projec',
    method: 'put',
    data: data
  })
}

// 删除关键技术
export function delProjec(id) {
  return request({
    url: '/projec/projec/' + id,
    method: 'delete'
  })
}
