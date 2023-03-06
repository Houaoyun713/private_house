import request from '@/utils/request'

// 查询项目实施方案列表
export function listProg(query) {
  return request({
    url: '/prog/prog/list',
    method: 'get',
    params: query
  })
}

// 查询项目实施方案详细
export function getProg(id) {
  return request({
    url: '/prog/prog/' + id,
    method: 'get'
  })
}

// 新增项目实施方案
export function addProg(data) {
  return request({
    url: '/prog/prog',
    method: 'post',
    data: data
  })
}

// 修改项目实施方案
export function updateProg(data) {
  return request({
    url: '/prog/prog',
    method: 'put',
    data: data
  })
}

// 删除项目实施方案
export function delProg(id) {
  return request({
    url: '/prog/prog/' + id,
    method: 'delete'
  })
}
