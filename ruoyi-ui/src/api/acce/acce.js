import request from '@/utils/request'

// 查询项目验收材料列表
export function listAcce(query) {
  return request({
    url: '/acce/acce/list',
    method: 'get',
    params: query
  })
}

// 查询项目验收材料详细
export function getAcce(id) {
  return request({
    url: '/acce/acce/' + id,
    method: 'get'
  })
}

// 新增项目验收材料
export function addAcce(data) {
  return request({
    url: '/acce/acce',
    method: 'post',
    data: data
  })
}

// 修改项目验收材料
export function updateAcce(data) {
  return request({
    url: '/acce/acce',
    method: 'put',
    data: data
  })
}

// 删除项目验收材料
export function delAcce(id) {
  return request({
    url: '/acce/acce/' + id,
    method: 'delete'
  })
}
